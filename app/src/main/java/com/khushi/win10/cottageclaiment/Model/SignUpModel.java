package com.khushi.win10.cottageclaiment.Model;

/**
 * Created by SONY on 18-03-2017.
 */

public class SignUpModel {

    /**
     * status : 1
     * user_details : {"r_id":26,"l_id":16,"f_name":"nisargm","l_name":"merchant","address":"abad","state_name":"Gujarat","city_name":"Surat","area_name":"Navsari","ph_no":"9278376466","email":"merchantaaaaaa@gmail.com","u_name":"nishu","psd":"nishu","sec_id":"What is your pet name ?","ans":"ans"}
     * message : Customer registration is successfully done.
     */

    private int status;
    private UserDetailsBean user_details;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserDetailsBean getUser_details() {
        return user_details;
    }

    public void setUser_details(UserDetailsBean user_details) {
        this.user_details = user_details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class UserDetailsBean {
        /**
         * r_id : 26
         * l_id : 16
         * f_name : nisargm
         * l_name : merchant
         * address : abad
         * state_name : Gujarat
         * city_name : Surat
         * area_name : Navsari
         * ph_no : 9278376466
         * email : merchantaaaaaa@gmail.com
         * u_name : nishu
         * psd : nishu
         * sec_id : What is your pet name ?
         * ans : ans
         */

        private int r_id;
        private int l_id;
        private String f_name;
        private String l_name;
        private String address;
        private String state_name;
        private String city_name;
        private String area_name;
        private String ph_no;
        private String email;
        private String u_name;
        private String psd;
        private String sec_id;
        private String ans;

        public int getR_id() {
            return r_id;
        }

        public void setR_id(int r_id) {
            this.r_id = r_id;
        }

        public int getL_id() {
            return l_id;
        }

        public void setL_id(int l_id) {
            this.l_id = l_id;
        }

        public String getF_name() {
            return f_name;
        }

        public void setF_name(String f_name) {
            this.f_name = f_name;
        }

        public String getL_name() {
            return l_name;
        }

        public void setL_name(String l_name) {
            this.l_name = l_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getState_name() {
            return state_name;
        }

        public void setState_name(String state_name) {
            this.state_name = state_name;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public String getPh_no() {
            return ph_no;
        }

        public void setPh_no(String ph_no) {
            this.ph_no = ph_no;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getU_name() {
            return u_name;
        }

        public void setU_name(String u_name) {
            this.u_name = u_name;
        }

        public String getPsd() {
            return psd;
        }

        public void setPsd(String psd) {
            this.psd = psd;
        }

        public String getSec_id() {
            return sec_id;
        }

        public void setSec_id(String sec_id) {
            this.sec_id = sec_id;
        }

        public String getAns() {
            return ans;
        }

        public void setAns(String ans) {
            this.ans = ans;
        }
    }
}