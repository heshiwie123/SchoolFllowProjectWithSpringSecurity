旧版基于内存的SpringSecurity配置：

@Configuration
@EnableWebSecurity
//启用基于方法的注解
@EnableMethodSecurity
public class SecurityConfig {
//配置相关过滤器
//安全框架都是一堆过滤器链
@Bean
public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//关闭csrf
httpSecurity.csrf(csrf -> csrf.disable());

        //配置请求拦截方式随意访问
        //针对请求配置
        //.permitAll()允许所有人访问
        //hasAnyRole("admin","user")，有其中一个角色就可以了
        //hasAuthority("allActivity:show")需要具有权限
        //hasRole跟hasAuthority不能一起用
        httpSecurity.authorizeHttpRequests(
                authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/to_login").permitAll()
//                        .requestMatchers("/allActivity").hasAnyRole("admin","user")
//                        .requestMatchers("/allActivity").hasAuthority("allActivity:show")
.anyRequest().authenticated());
//form,Basic等
//.loginPage    登录页面的URL路径
//.loginProcessingUrl   实际处理登录请求的URL路径
httpSecurity.formLogin(form -> form.loginPage("/to_login")//跳转到自定义的登陆页面
.loginProcessingUrl("/doLogin")//处理前端的请求，与form表单的action一致
.usernameParameter("username")
.passwordParameter("password")
.defaultSuccessUrl("/to_index")//请求到index接口上
);
return httpSecurity.build();
}

    //权限访问控制
    @Bean
    public UserDetailsService userDetailsService() {
        //定义用户信息，
        //构建普通用户
        UserDetails user = User.withUsername("user")
                .password("$2a$10$ZAauFXwJHruCYjewmRaQW..hOdIew66KEit4hKLMMiQP4cHSUpqKe")
                .roles("user")
                .authorities("test1:show")
                .build();
        //构建管理员
        UserDetails admin = User.withUsername("xiaozhang")
                .password("$2a$10$ZAauFXwJHruCYjewmRaQW..hOdIew66KEit4hKLMMiQP4cHSUpqKe")
                .roles("admin", "user")
                //配置权限
                // @PreAuthorize("hasRole('test:show')")会加上ROLE_变为=》ROLE_test:show与 .authorities("test:show")匹配、
                //而不是取上面的 .roles("admin", "user")来判断
                .authorities("test:show")
                .build();
        //用户存储到springsecurity中
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        //创建两个用户
        userDetailsManager.createUser(user);
        userDetailsManager.createUser(admin);

        return userDetailsManager;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
