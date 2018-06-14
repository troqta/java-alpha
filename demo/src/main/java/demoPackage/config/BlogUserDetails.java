import org.springframework.security.core.userdetails.UserDetails;
import demoPackage.entity.User;

public class BlogUserDetails extends User implements UserDetails {
    @Overide
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
        return true;
    }

    private ArrayList<String> roles;
    private User user;

    public BlogUserDetails(User user, ArrayList<String> roles) {
        super(user.getEmail(), user.getFullName(), user.getPassword());

        this.roles = roles;
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        String userRoles = StringUtils.collectionToCommaDelimtiedString(this.roles);
        return AuthorityUtils.comaSeparatedStringToAuthorityList(userRoles);
    }
    public User getUser(){
        return this.user;
    }
}