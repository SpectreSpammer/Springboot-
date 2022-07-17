package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.config;


//@EnableWebSecurity, extends WebSecurityConfigurerAdapter
public class SecurityConfig  {
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser
                        ("nan").password(passwordEncoder().encode
                        ("1234"))
                   .roles("USER").and().withUser
                        ("admin").password(passwordEncoder().encode
                        (""));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

       http.authorizeRequests().antMatchers(
               "/api/v1/customer/create")
               .hasRole("ADMIN").anyRequest().authenticated().and().httpBasic();
      http.csrf().disable();
    }

         @Bean
      public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
      }

*/




}
