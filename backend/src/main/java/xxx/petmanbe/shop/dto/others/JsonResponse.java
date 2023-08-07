package xxx.petmanbe.shop.dto.others;

import lombok.Getter;

import java.util.List;

@Getter
public class JsonResponse {
    private List<Data1> documents;
    private Data2 meta;

    public static class Data1 {
        public String address;
        public String address_name;
        public String address_type;
        public Data3 road_address;
        public double x;
        public double y;

    }

    public static class Data3{

        public String address_name;
        public String building_name;
        public String main_building_no;
        public String region_1depth_name;
        public String region_2depth_name;
        public String region_3depth_name;
        public String road_name;
        public String sub_building_no;
        public String underground_yn;
        public double x;
        public double y;
        public String zone_no;


    }

    public static class Data2{
        public boolean is_end;
        public int pageable_count;
        public int total_count;

    }


}
