package by.training.project.beans;

import java.util.List;

public class Hotel extends Entity { // TODO inner class, todo toString equals hashCode\

    private Facilities facilities;
    private Prices prices;
    private Address address;
    private int adminId;
    private String name;
    private int stars;

    public class Facilities {
        private int typeFood;
        private int typeAllocation;
        private int typeComfort;
        private int typeRoom;
        private boolean parking;
        private boolean wifi;
        private boolean pets;
        private boolean business;

        private Facilities() {
        }

        public int getTypeFood() {
            return typeFood;
        }

        public void setTypeFood(int typeFood) {
            this.typeFood = typeFood;
        }

        public int getTypeAllocation() {
            return typeAllocation;
        }

        public void setTypeAllocation(int typeAllocation) {
            this.typeAllocation = typeAllocation;
        }

        public int getTypeComfort() {
            return typeComfort;
        }

        public void setTypeComfort(int typeComfort) {
            this.typeComfort = typeComfort;
        }

        public int getTypeRoom() {
            return typeRoom;
        }

        public void setTypeRoom(int typeRoom) {
            this.typeRoom = typeRoom;
        }

        public boolean isParking() {
            return parking;
        }

        public void setParking(boolean parking) {
            this.parking = parking;
        }

        public boolean isWifi() {
            return wifi;
        }

        public void setWifi(boolean wifi) {
            this.wifi = wifi;
        }

        public boolean isPets() {
            return pets;
        }

        public void setPets(boolean pets) {
            this.pets = pets;
        }

        public boolean isBusiness() {
            return business;
        }

        public void setBusiness(boolean business) {
            this.business = business;
        }
    }

    public class Prices {
        private int[] priceRoom = new int[5];
        private int[] priceComfort = new int[4];
        private int rewardTourOperator;

        private Prices() {
        }

        public int[] getPriceRoomIntArr() {
            return priceRoom;
        }

        public void setPriceRoomIntArr(int[] priceRoom) {
            this.priceRoom = priceRoom;
        }

        public String getPriceRoom() {
            return priceRoomToStringValue(this.priceRoom);
        }

        public void setPriceRoom(String priceRoom) {
            this.priceRoom = priceRoomToIntArr(priceRoom);
        }

        public int[] getPriceComfortIntArr() {
            return priceComfort;
        }

        public void setPriceComfortIntArr(int[] priceComfort) {
            this.priceComfort = priceComfort;
        }

        public String getPriceComfort() {
            return priceComfortToStringValue(priceComfort);
        }

        public void setPriceComfort(String priceComfort) {
            this.priceComfort = priceComfortToIntArr(priceComfort);
        }

        public int getRewardTourOperator() {
            return rewardTourOperator;
        }

        public void setRewardTourOperator(int rewardTourOperator) {
            this.rewardTourOperator = rewardTourOperator;
        }

        private int[] priceRoomToIntArr(String priceRooms) {
            int[] priceRoomArr = new int[5];
            priceRoomArr[0] = Integer.parseInt(priceRooms.substring(0, 5));
            priceRoomArr[1] = Integer.parseInt(priceRooms.substring(5, 10));
            priceRoomArr[2] = Integer.parseInt(priceRooms.substring(10, 15));
            priceRoomArr[3] = Integer.parseInt(priceRooms.substring(15, 20));
            priceRoomArr[4] = Integer.parseInt(priceRooms.substring(20, 25));
            return priceRoomArr;
        }

        private String priceRoomToStringValue(int[] priceRooms) {
            StringBuffer priceRoomsStr = new StringBuffer();
            StringBuffer priceOneRoomStr = new StringBuffer();
            for (int priceOneRoom : priceRooms) {
                priceOneRoomStr.append(priceOneRoom);
                while (priceOneRoomStr.length() != 5) {
                    priceOneRoomStr.insert(0, '0');
                }
                priceRoomsStr.append(priceOneRoomStr);
            }
            return priceRoomsStr.toString();
        }

        private int[] priceComfortToIntArr(String priceComfort) {
            int[] priceComfortArr = new int[4];
            priceComfortArr[0] = Integer.parseInt(priceComfort.substring(0, 5));
            priceComfortArr[1] = Integer.parseInt(priceComfort.substring(5, 10));
            priceComfortArr[2] = Integer.parseInt(priceComfort.substring(10, 15));
            return priceComfortArr;
        }

        private String priceComfortToStringValue(int[] priceComfort) {
            StringBuffer priceComfortStr = new StringBuffer();
            StringBuffer priceOneTypeComfortStr = new StringBuffer();
            for (int price : priceComfort) {
                priceOneTypeComfortStr.append(price);
                while (priceOneTypeComfortStr.length() != 5) {
                    priceOneTypeComfortStr.insert(0, '0');
                }
                priceComfortStr.append(priceOneTypeComfortStr);
            }
            return priceComfortStr.toString();
        }
    }

    public class Address {
        private String countryCode;
        private String countryName;
        private String city;
        private String street;
        private int house;
        private int building;

        private Address() {
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public int getHouse() {
            return house;
        }

        public void setHouse(int house) {
            this.house = house;
        }

        public int getBuilding() {
            return building;
        }

        public void setBuilding(int building) {
            this.building = building;
        }
    }

    private List<Room> listRoom;

    public Hotel() {
        this.facilities = new Facilities();
        this.prices = new Prices();
        this.address = new Address();
    }

    public Facilities getFacilities() {
        return facilities;
    }

    public Prices getPrices() {
        return prices;
    }

    public Address getAddress() {
        return address;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(List<Room> listRoom) {
        this.listRoom = listRoom;
    }
}
