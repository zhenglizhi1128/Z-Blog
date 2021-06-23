package com.zhenglz.vo;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.zhenglz.common.Constants;
import com.zhenglz.entity.Permission;
import com.zhenglz.entity.Role;
import com.zhenglz.entity.User;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 自定义User
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-10 15:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPrincipal implements UserDetails {

    private static final long serialVersionUID = 2645835313684650630L;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别，男-1，女-2
     */
    private Integer sex;

    /**
     * 状态，启用-1，禁用-0
     */
    private Boolean status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 用户角色列表
     */
    private List<String> roles;

    /**
     * 用户权限列表
     */
    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(User user, List<Role> roles, List<Permission> permissions) {
        List<String> roleNames = roles.stream().map(Role::getName).collect(Collectors.toList());

        List<GrantedAuthority> authorities =
            permissions.stream().filter(permission -> StrUtil.isNotBlank(permission.getPermission()))
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toList());

        return new UserPrincipal(user.getId(), user.getUsername(), user.getPassword(), user.getNickname(),
            user.getPhone(), user.getEmail(), user.getBirthday(), user.getSex(), user.getStatus(), user.getCreateTime(),
            user.getUpdateTime(), roleNames, authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Objects.equals(this.status, Constants.TRYE);
    }
}
