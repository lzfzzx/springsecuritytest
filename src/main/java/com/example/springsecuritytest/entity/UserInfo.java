package com.example.springsecuritytest.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * Created by Lzf on 2020/4/26.
 */
@Data

//public class UserInfo implements UserDetails,Serializable {
public class UserInfo {
    private static final long serialVersionUID = 1L;
//    接口声明简单视图和详细视图，详细视图继承简单视图
    public interface UserSimpleViews{};
    public interface UserDetailView extends UserSimpleViews{};
//    指定视图
    @JsonView(UserSimpleViews.class)
    private String username;
    @JsonView(UserDetailView.class)
    private String password;


//    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
//    @JoinTable(name = "userinfo_authority", joinColumns = @JoinColumn(name = "userinf_id", referencedColumnName = "autoid"),
//            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "autoid"))
//    private List<Authority> authorities;

//    JPA 的规范要求无参构造函数；设为 protected 防止直接使用
//    protected  UserInfo(){
//
//    }

//    @Transient
//    public static final String SESSION_NAME = "lOGIN_USER";

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        //  需将 List<Authority> 转成 List<SimpleGrantedAuthority>，否则前端拿不到角色列表名称
//        List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<>();
//        for(GrantedAuthority authority : this.authorities){
//            simpleAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
//        }
//        return simpleAuthorities;
//    }
//    public void setAuthorities(List<Authority> authorities){
//        this.authorities = authorities;
//    }
//    public void setEncodePassword(String password) {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodePasswd = encoder.encode(password);
//        this.password = encodePasswd;
//    }
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
}
