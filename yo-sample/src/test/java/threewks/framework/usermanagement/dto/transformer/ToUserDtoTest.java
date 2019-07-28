package threewks.framework.usermanagement.dto.transformer;

import org.junit.Before;
import org.junit.Test;
import threewks.framework.usermanagement.dto.UserDto;
import threewks.framework.usermanagement.model.User;
import threewks.testinfra.TestData;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ToUserDtoTest {

    private User user;

    @Before
    public void before() {
        user = TestData.setCreatedUpdated(TestData.user());
    }

    @Test
    public void apply_willTransform_excludingPassword() {
        UserDto dto = ToUserDto.INSTANCE.apply(user);

        assertUserMatches(user, dto);
    }

    @Test
    public void fromInstance_willPopulateEmptySubclassInstance() {
        TestUserDto dto = ToUserDto.INSTANCE.fromInstance(user, new TestUserDto());

        assertUserMatches(user, dto);
    }

    private static void assertUserMatches(User user, UserDto dto) {
        assertThat(dto.getId(), is(user.getId()));
        assertThat(dto.getEmail(), is(user.getEmail()));
        assertThat(dto.getFirstName(), is(user.getFirstName()));
        assertThat(dto.getLastName(), is(user.getLastName()));
        assertThat(dto.getName(), is(user.getFullName()));
        assertThat(dto.getRoles(), is(user.getRoles()));
        assertThat(dto.getCreated(), is(user.getCreated()));
        assertThat(dto.getUpdated(), is(user.getUpdated()));
    }

    private class TestUserDto extends UserDto {

    }

}
