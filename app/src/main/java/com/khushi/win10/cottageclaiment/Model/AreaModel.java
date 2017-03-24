package com.khushi.win10.cottageclaiment.Model;

import java.util.List;

/**
 * Created by Deep Joshi on 25-03-2017.
 */

public class AreaModel {

    /**
     * status : 1
     * AreaList : [{"area_name":"Gandhibagh","area_id":18,"city_name":"Nagpur","state_name":"Maharastra"},{"area_name":"Nandanvan","area_id":19,"city_name":"Nagpur","state_name":"Maharastra"},{"area_name":"Seminary Hills","area_id":20,"city_name":"Nagpur","state_name":"Maharastra"},{"area_name":"Gandhinagar","area_id":21,"city_name":"Nagpur","state_name":"Maharastra"}]
     */

    private int status;
    private List<AreaListBean> AreaList;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<AreaListBean> getAreaList() {
        return AreaList;
    }

    public void setAreaList(List<AreaListBean> AreaList) {
        this.AreaList = AreaList;
    }

    public static class AreaListBean {
        /**
         * area_name : Gandhibagh
         * area_id : 18
         * city_name : Nagpur
         * state_name : Maharastra
         */

        private String area_name;
        private int area_id;
        private String city_name;
        private String state_name;

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public int getArea_id() {
            return area_id;
        }

        public void setArea_id(int area_id) {
            this.area_id = area_id;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getState_name() {
            return state_name;
        }

        public void setState_name(String state_name) {
            this.state_name = state_name;
        }
    }
}
