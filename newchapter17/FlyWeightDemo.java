/**
 * Fly Weight Demo
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class FlyWeightDemo extends AbstractMap<String,String> {
    private final int mapSize;
    public FlyWeightDemo(int num) {
        mapSize = num;
    }
    public static final String[][] DATA = {
        // Africa
        {"ALGERIA","Algiers"}, {"ANGOLA","Luanda"},
        {"BENIN","Porto-Novo"}, {"BOTSWANA","Gaberone"},
        {"BURKINA FASO","Ouagadougou"},
        {"BURUNDI","Bujumbura"},
        {"CAMEROON","Yaounde"}, {"CAPE VERDE","Praia"},
        {"CENTRAL AFRICAN REPUBLIC","Bangui"},
        {"CHAD","N’djamena"}, {"COMOROS","Moroni"},
        {"CONGO","Brazzaville"}, {"DJIBOUTI","Dijibouti"},
        {"EGYPT","Cairo"}, {"EQUATORIAL GUINEA","Malabo"},
        {"ERITREA","Asmara"}, {"ETHIOPIA","Addis Ababa"},
        {"GABON","Libreville"}, {"THE GAMBIA","Banjul"},
        {"GHANA","Accra"}, {"GUINEA","Conakry"},
        {"BISSAU","Bissau"},
        {"COTE D’IVOIR (IVORY COAST)","Yamoussoukro"},
        {"KENYA","Nairobi"}, {"LESOTHO","Maseru"},
        {"LIBERIA","Monrovia"}, {"LIBYA","Tripoli"},
        {"MADAGASCAR","Antananarivo"}, {"MALAWI","Lilongwe"},
        {"MALI","Bamako"}, {"MAURITANIA","Nouakchott"},
        {"MAURITIUS","Port Louis"}, {"MOROCCO","Rabat"},
        {"MOZAMBIQUE","Maputo"}, {"NAMIBIA","Windhoek"},
        {"NIGER","Niamey"}, {"NIGERIA","Abuja"},
        {"RWANDA","Kigali"},
        {"SAO TOME E PRINCIPE","Sao Tome"},
        {"SENEGAL","Dakar"}, {"SEYCHELLES","Victoria"},
        {"SIERRA LEONE","Freetown"}, {"SOMALIA","Mogadishu"},
        {"SOUTH AFRICA","Pretoria/Cape Town"},
        {"SUDAN","Khartoum"},
        {"SWAZILAND","Mbabane"}, {"TANZANIA","Dodoma"},
        {"TOGO","Lome"}, {"TUNISIA","Tunis"},
        {"UGANDA","Kampala"},
        {"DEMOCRATIC REPUBLIC OF THE CONGO (ZAIRE)",
        "Kinshasa"},
        {"ZAMBIA","Lusaka"}, {"ZIMBABWE","Harare"},
        // Asia
        {"AFGHANISTAN","Kabul"}, {"BAHRAIN","Manama"},
        {"BANGLADESH","Dhaka"}, {"BHUTAN","Thimphu"},
        {"BRUNEI","Bandar Seri Begawan"},
        {"CAMBODIA","Phnom Penh"},
        {"CHINA","Beijing"}, {"CYPRUS","Nicosia"},
        {"INDIA","New Delhi"}, {"INDONESIA","Jakarta"},
        {"IRAN","Tehran"}, {"IRAQ","Baghdad"},
        {"ISRAEL","Jerusalem"}, {"JAPAN","Tokyo"},
        {"JORDAN","Amman"}, {"KUWAIT","Kuwait City"},
        {"LAOS","Vientiane"}, {"LEBANON","Beirut"},
        {"MALAYSIA","Kuala Lumpur"}, {"THE MALDIVES","Male"},
        {"MONGOLIA","Ulan Bator"},
        {"MYANMAR (BURMA)","Rangoon"},
        {"NEPAL","Katmandu"}, {"NORTH KOREA","P’yongyang"},
        {"OMAN","Muscat"}, {"PAKISTAN","Islamabad"},
        {"PHILIPPINES","Manila"}, {"QATAR","Doha"},
        {"SAUDI ARABIA","Riyadh"}, {"SINGAPORE","Singapore"},
        {"SOUTH KOREA","Seoul"}, {"SRI LANKA","Colombo"},
        {"SYRIA","Damascus"},
        {"TAIWAN (REPUBLIC OF CHINA)","Taipei"},
        {"THAILAND","Bangkok"}, {"TURKEY","Ankara"},
        {"UNITED ARAB EMIRATES","Abu Dhabi"},
        {"VIETNAM","Hanoi"}, {"YEMEN","Sana’a"},
        // Australia and Oceania
        {"AUSTRALIA","Canberra"}, {"FIJI","Suva"},
        {"KIRIBATI","Bairiki"},
        {"MARSHALL ISLANDS","Dalap-Uliga-Darrit"},
        {"MICRONESIA","Palikir"}, {"NAURU","Yaren"},
        {"NEW ZEALAND","Wellington"}, {"PALAU","Koror"},
        {"PAPUA NEW GUINEA","Port Moresby"},
        {"SOLOMON ISLANDS","Honaira"}, {"TONGA","Nuku’alofa"},
        {"TUVALU","Fongafale"}, {"VANUATU","< Port-Vila"},
        {"WESTERN SAMOA","Apia"},
        // Eastern Europe and former USSR
        {"ARMENIA","Yerevan"}, {"AZERBAIJAN","Baku"},
        {"BELARUS (BYELORUSSIA)","Minsk"},
        {"BULGARIA","Sofia"}, {"GEORGIA","Tbilisi"},
        {"KAZAKSTAN","Almaty"}, {"KYRGYZSTAN","Alma-Ata"},
        {"MOLDOVA","Chisinau"}, {"RUSSIA","Moscow"},
        {"TAJIKISTAN","Dushanbe"}, {"TURKMENISTAN","Ashkabad"},
        {"UKRAINE","Kyiv"}, {"UZBEKISTAN","Tashkent"},
        // Europe
        {"ALBANIA","Tirana"}, {"ANDORRA","Andorra la Vella"},
        {"AUSTRIA","Vienna"}, {"BELGIUM","Brussels"},
        {"BOSNIA","-"}, {"HERZEGOVINA","Sarajevo"},
        {"CROATIA","Zagreb"}, {"CZECH REPUBLIC","Prague"},
        {"DENMARK","Copenhagen"}, {"ESTONIA","Tallinn"},
        {"FINLAND","Helsinki"}, {"FRANCE","Paris"},
        {"GERMANY","Berlin"}, {"GREECE","Athens"},
        {"HUNGARY","Budapest"}, {"ICELAND","Reykjavik"},
        {"IRELAND","Dublin"}, {"ITALY","Rome"},
        {"LATVIA","Riga"}, {"LIECHTENSTEIN","Vaduz"},
        {"LITHUANIA","Vilnius"}, {"LUXEMBOURG","Luxembourg"},
        {"MACEDONIA","Skopje"}, {"MALTA","Valletta"},
        {"MONACO","Monaco"}, {"MONTENEGRO","Podgorica"},
        {"THE NETHERLANDS","Amsterdam"}, {"NORWAY","Oslo"},
        {"POLAND","Warsaw"}, {"PORTUGAL","Lisbon"},
        {"ROMANIA","Bucharest"}, {"SAN MARINO","San Marino"},
        {"SERBIA","Belgrade"}, {"SLOVAKIA","Bratislava"},
        {"SLOVENIA","Ljuijana"}, {"SPAIN","Madrid"},
        {"SWEDEN","Stockholm"}, {"SWITZERLAND","Berne"},
        {"UNITED KINGDOM","London"}, {"VATICAN CITY","---"},
        // North and Central America
        {"ANTIGUA AND BARBUDA","Saint John’s"},
        {"BAHAMAS","Nassau"},
        {"BARBADOS","Bridgetown"}, {"BELIZE","Belmopan"},
        {"CANADA","Ottawa"}, {"COSTA RICA","San Jose"},
        {"CUBA","Havana"}, {"DOMINICA","Roseau"},
        {"DOMINICAN REPUBLIC","Santo Domingo"},
        {"EL SALVADOR","San Salvador"},
        {"GRENADA","Saint George’s"},
        {"GUATEMALA","Guatemala City"},
        {"HAITI","Port-au-Prince"},
        {"HONDURAS","Tegucigalpa"}, {"JAMAICA","Kingston"},
        {"MEXICO","Mexico City"}, {"NICARAGUA","Managua"},
        {"PANAMA","Panama City"}, {"ST. KITTS","-"},
        {"NEVIS","Basseterre"}, {"ST. LUCIA","Castries"},
        {"ST. VINCENT AND THE GRENADINES","Kingstown"},
        {"UNITED STATES OF AMERICA","Washington, D.C."},
        // South America
        {"ARGENTINA","Buenos Aires"},
        {"BOLIVIA","Sucre (legal)/La Paz(administrative)"},
        {"BRAZIL","Brasilia"}, {"CHILE","Santiago"},
        {"COLOMBIA","Bogota"}, {"ECUADOR","Quito"},
        {"GUYANA","Georgetown"}, {"PARAGUAY","Asuncion"},
        {"PERU","Lima"}, {"SURINAME","Paramaribo"},
        {"TRINIDAD AND TOBAGO","Port of Spain"},
        {"URUGUAY","Montevideo"}, {"VENEZUELA","Caracas"},
    };

    // 实现 Map.Entry<String,String> 接口
    public static class Country implements Map.Entry<String,String> {
        String[] info = new String[2];
        public Country(String name, String capital) {
            info[0] = name;
            info[1] = capital;
        }
        public String getKey() {
            return new String(info[0]);
        }
        public String getValue() {
            return new String(info[1]);
        }
        public String setValue(String value) {
            String oldValue = getValue();
            info[1] = value;
            return oldValue;
        }
        public String setKey(String key) {
            String oldKey = getKey();
            info[0] = key;
            return oldKey;
        }
        public boolean equals(Object o) {
            if (!(o instanceof Country)) {
                return false;
            }
            Country countryTwo = (Country)o;
            boolean result1 = info[0].equals(countryTwo.getKey());
            boolean result2 = info[1].equals(countryTwo.getValue());
            return result1 && result2;
        }
        public int hashCode() {
            return info[0].hashCode() + info[1].hashCode();
        }
    }
    // 重写 iterator(), size()
    public static class CountrySet extends AbstractSet<Map.Entry<String,String>> {
        private int setSize = 0;
        public CountrySet(int num) {
            setSize = num;
        }
        public Iterator<Map.Entry<String,String>> iterator() {
            return new Iterator<Map.Entry<String,String>>() {
                private int index = 0;
                private Country viewWindow = new Country("NULL","NULL");
                public boolean hasNext() {
                    return index < setSize;
                }
                public Map.Entry<String,String> next() {
                    String[] data = DATA[(index++)%setSize];
                    viewWindow.setKey(data[0]);
                    viewWindow.setValue(data[1]);
                    return viewWindow;
                }
                public void remove() {
                    throw new UnsupportedOperationException("CountrySet.Iterator#remove() is opetional!");
                }
            };
        }
        public int size() {
            return setSize;
        }
    }
    public Set<Map.Entry<String,String>> entrySet() {
        return new CountrySet(mapSize);
    }
    public static void main(String[] args) {
        FlyWeightDemo countries = new FlyWeightDemo(19);
        List<Map.Entry<String,String>> result = new ArrayList<Map.Entry<String,String>>();
        Formatter f = new Formatter(System.out);
        System.out.println("直接打印视窗：");
        for (Map.Entry<String,String> c : countries.entrySet()) {
            f.format("%1$10.10s %2$-20.20s %3$10.10s %4$-20.20s \n","Country: ", c.getKey(), "Capital: ", c.getValue());
            result.add(c);
        }
        System.out.println("视窗地址插入List：");
        for (Map.Entry<String,String> c : result) {
            f.format("%1$10.10s %2$-20.20s %3$10.10s %4$-20.20s \n","Country: ", c.getKey(), "Capital: ", c.getValue());
        }
    }
}
