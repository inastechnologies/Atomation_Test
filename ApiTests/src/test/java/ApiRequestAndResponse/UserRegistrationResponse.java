package ApiRequestAndResponse;

import java.util.List;

public class UserRegistrationResponse
{
    public String message;
    public List<Result> result;
    public int status;

    public static class Result
    {
        public String User_verified;
        public String device_token;
        public String email_id;
        public String encoded_password;
        public String facebook_id;
        public String first_name;
        public String gender;
        public String google_id;
        public String last_name;
        public String location;
        public String mobile_number;
        public String password;
        public int type;
        public String user_id;
    }
}
