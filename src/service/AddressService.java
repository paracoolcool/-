package service;

import pojo.Address;

import java.util.List;

public interface AddressService {

    int  addAddress(String name,
                    String phone,
                    String sheng,
                    String city,
                    String add_msg,
                    String type,
                    String area,
                    int uid);

    List<Address> findAddByuid(int uid);

    int deleteAddress(int aid);


}
