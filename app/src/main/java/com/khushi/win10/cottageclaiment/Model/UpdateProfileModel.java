package com.khushi.win10.cottageclaiment.Model;

/**
 * Created by SONY on 18-03-2017.
 */

public class UpdateProfileModel {

    /**
     * status : 1
     * user_updated_details : {"r_id":25,"f_name":"nisarg","l_name":"nisarg","address":"ahmedabad","state_name":"Gujarat","city_name":"Surat","area_name":"Adalaj","ph_no":"992383482","email":"merchant@gmail.com"}
     * message : Profile Updated Successfully.
     */

    private int status;
    private UserUpdatedDetailsBean user_updated_details;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserUpdatedDetailsBean getUser_updated_details() {
        return user_updated_details;
    }

    public void setUser_updated_details(UserUpdatedDetailsBean user_updated_details) {
        this.user_updated_details = user_updated_details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class UserUpdatedDetailsBean {
        /**
         * r_id : 25
         * f_name : nisarg
         * l_name : nisarg
         * address : ahmedabad
         * state_name : Gujarat
         * city_name : Surat
         * area_name : Adalaj
         * ph_no : 992383482
         * email : merchant@gmail.com
         */

        private int r_id;
        private String f_name;
        private String l_name;
        private String address;
        private String state_name;
        private String city_name;
        private String area_name;
        private String ph_no;
        private String email;

        public int getR_id() {
            return r_id;
        }

        public void setR_id(int r_id) {
            this.r_id = r_id;
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
    }
}
