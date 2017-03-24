package com.khushi.win10.cottageclaiment.Model;

import java.util.List;

/**
 * Created by Deep Joshi on 24-03-2017.
 */

public class StateModel {

    /**
     * status : 1
     * CityList : [{"city_name":"Ahmedabad","city_id":1,"state_name":"Gujarat"},{"city_name":"Surat","city_id":2,"state_name":"Gujarat"},{"city_name":"Baroda","city_id":3,"state_name":"Gujarat"},{"city_name":"Bhavnagar","city_id":16,"state_name":"Gujarat"}]
     */

    private int status;
    private List<CityListBean> CityList;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<CityListBean> getCityList() {
        return CityList;
    }

    public void setCityList(List<CityListBean> CityList) {
        this.CityList = CityList;
    }

    public static class CityListBean {
        /**
         * city_name : Ahmedabad
         * city_id : 1
         * state_name : Gujarat
         */

        private String city_name;
        private int city_id;
        private String state_name;

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public String getState_name() {
            return state_name;
        }

        public void setState_name(String state_name) {
            this.state_name = state_name;
        }
    }
}
