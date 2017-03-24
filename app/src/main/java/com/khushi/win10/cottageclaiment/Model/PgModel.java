package com.khushi.win10.cottageclaiment.Model;

/**
 * Created by Deep Joshi on 25-03-2017.
 */

public class PgModel {

    /**
     * status : 1
     * pgAppList : {"pg_id":1,"o_name":"owner a","address":"asdf","state_name":"Gujarat","city_name":"Ahmedabad","area_name":"navrangpura","ph_no":"9427313687","email":"reepal231994@gmail.com","e_price":"15000","str_date":"2016-10-11","end_date":"2017-10-11"}
     */

    private int status;
    private PgAppListBean pgAppList;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public PgAppListBean getPgAppList() {
        return pgAppList;
    }

    public void setPgAppList(PgAppListBean pgAppList) {
        this.pgAppList = pgAppList;
    }

    public static class PgAppListBean {
        /**
         * pg_id : 1
         * o_name : owner a
         * address : asdf
         * state_name : Gujarat
         * city_name : Ahmedabad
         * area_name : navrangpura
         * ph_no : 9427313687
         * email : reepal231994@gmail.com
         * e_price : 15000
         * str_date : 2016-10-11
         * end_date : 2017-10-11
         */

        private int pg_id;
        private String o_name;
        private String address;
        private String state_name;
        private String city_name;
        private String area_name;
        private String ph_no;
        private String email;
        private String e_price;
        private String str_date;
        private String end_date;

        public int getPg_id() {
            return pg_id;
        }

        public void setPg_id(int pg_id) {
            this.pg_id = pg_id;
        }

        public String getO_name() {
            return o_name;
        }

        public void setO_name(String o_name) {
            this.o_name = o_name;
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

        public String getE_price() {
            return e_price;
        }

        public void setE_price(String e_price) {
            this.e_price = e_price;
        }

        public String getStr_date() {
            return str_date;
        }

        public void setStr_date(String str_date) {
            this.str_date = str_date;
        }

        public String getEnd_date() {
            return end_date;
        }

        public void setEnd_date(String end_date) {
            this.end_date = end_date;
        }
    }
}
