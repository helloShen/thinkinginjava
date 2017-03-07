/**
 * Fly Weight Demo 2
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;
import java.util.regex.*;

/**
 * 用来自动生成包含国家首都信息的List,Set或Map。
 * 前半部分是包含所有国家首都信息的享元Map。
 * 后半部分是把享元index信息转化成实际副本的脚本。
 */
public class Countries extends AbstractMap<String,String> {
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
    public static int countriesSize() {
        return DATA.length;
    }
    private int countriesSize;
    public Countries() {
        this(DATA.length);
    }
    public Countries(int num) {
        countriesSize = num;
        if (countriesSize < 0) {
            countriesSize = 0;
        }
        if (countriesSize > DATA.length) {
            countriesSize = DATA.length;
        }
    }
    public int size() {
        return countriesSize;
    }
    public static class Country implements Map.Entry<String,String> {
        private int index=0;
        public Country(int num) {
            index = num;
        }
        public String getKey() {
            return DATA[index][0];
        }
        public String getValue() {
            return DATA[index][1];
        }
        public String setValue(String str) {
            throw new UnsupportedOperationException();
        }
        public boolean equals(Object o) {
            if (o == null || ! (o instanceof Country)) {
                return false;
            }
            return DATA[index][0].equals((Country)o);
        }
        public int hashCode() {
            return DATA[index][0].hashCode();
        }
    }
    public class CountrySet extends AbstractSet<Map.Entry<String,String>> {
        private int index = 0;
        private Country viewWindow = new Country(-1);
        public Iterator<Map.Entry<String,String>> iterator() {
            return new Iterator<Map.Entry<String,String>>() {
                public boolean hasNext() {
                    return index < countriesSize;
                }
                public Map.Entry<String,String> next() {
                    viewWindow.index++;
                    index++;
                    return viewWindow;
                }
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
        public int size() {
            return countriesSize;
        }
    }
    public Set<Map.Entry<String,String>> entrySet() {
        return new CountrySet();
    }

    /**
     * 完整健壮的方法从享元中提取副本
     */
    // read only country info container
    public static class CountryPair implements Map.Entry<String,String> {
        private final String name;
        private final String capital;
        public CountryPair(String key, String value) {
            name = key;
            capital = value;
        }
        public String getKey() {
            return name;
        }
        public String getValue() {
            return capital;
        }
        public String setValue(String vaule) {  // read only, so ignore
            throw new UnsupportedOperationException();
        }
        public boolean equals(Object o) {
            if (o == null || !(o instanceof CountryPair)) {
                return false;
            }
            return name.equals(((CountryPair)o).getKey());
        }
        public int hashCode() {
            return name.hashCode();
        }
        public String toString() {
            return "(" + name + " = " + capital + ")";
        }
    }

    // transfer the view to copy
    public static List<Map.Entry<String,String>> getSortedCountries() {
        return getSortedCountries(DATA.length);
    }
    // return a sublist of the preload countries list
    public static List<Map.Entry<String,String>> getSortedCountries(int size) {
        List<Map.Entry<String,String>> countries = new ArrayList<Map.Entry<String,String>>();
        Set<Map.Entry<String,String>> myCountrySet = new Countries(size).entrySet();
        for (Map.Entry<String,String> country : myCountrySet) {
            countries.add(new CountryPair(country.getKey(), country.getValue()));
        }
        Collections.sort(countries, new Comparator<Map.Entry<String,String>>() {
            public int compare(Map.Entry<String,String> country1, Map.Entry<String,String> country2) {
                return String.CASE_INSENSITIVE_ORDER.compare(country1.getKey(),country2.getKey());
            }
        });
        return countries;
    }
    // filter for some specific countries
    public static List<Map.Entry<String,String>> getCountriesByRegex(String regex) {
        List<Map.Entry<String,String>> resultList = new ArrayList<Map.Entry<String,String>>();
        Matcher m = Pattern.compile(regex).matcher("");
        for (Map.Entry<String,String> country : getSortedCountries()) {
            m = m.reset(country.getKey());
            if (m.find()) {
                resultList.add(country);
            }
        }
        return resultList;
    }
    public static <T> Set<T> fillSetByList(List<T> list) {
        Set<T> set = new HashSet<T>();
        set.addAll(list);
        return set;
    }
    public static <K,V> Map<K,V> fillMapByList(List<Map.Entry<K,V>> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Map<K,V> map = new HashMap<K,V>();
        for (Map.Entry<K,V> ele : list) {
            map.put(ele.getKey(),ele.getValue());
        }
        return map;
    }
    public static List<String> name() {
        return name(DATA.length);
    }
    public static List<String> name(int size) {
        List<String> names = new ArrayList<String>();
        if (names.addAll(new Countries(size).keySet())) {
            return names;
        } else {
            throw new RuntimeException("Error when inserting countries names set into list!");
        }
    }
    public static List<String> capital() {
        return capital(DATA.length);
    }
    public static List<String> capital(int size) {
        List<String> capitals = new ArrayList<String>();
        if (capitals.addAll(new Countries(size).values())) {
            return capitals;
        } else {
            throw new RuntimeException("Error when inserting countries capitals set into list!");
        }
    }
    public static void main(String[] args) {
        String regexA = "^[Aa]\\w*";
        List<Map.Entry<String,String>> countriesA = getCountriesByRegex(regexA);
        System.out.println("Countries list begin with A: \n" + countriesA);
        System.out.println("Countries set begin with A: \n" + fillSetByList(countriesA));
        System.out.println("Countries map begin with A: \n" + fillMapByList(countriesA));
        System.out.println("10 Country names: \n" + name(10));
        System.out.println("10 Country capitals: \n" + capital(10));
    }
}
