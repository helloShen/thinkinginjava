/**
 * Fly Weight Demo 2
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class FlyWeightMap extends AbstractMap<String,String> {
    public static int dataSize() {
        return DATA.length;
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
    private int countriesSize;
    public FlyWeightMap() {
        this(DATA.length);
    }
    public FlyWeightMap(int num) {
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

    public static void main(String[] args) {
        FlyWeightMap countriesMap = new FlyWeightMap(25);
        Formatter f = new Formatter(System.out);
        System.out.println("逐个打印迭代器返回元素：");
        for(Map.Entry<String,String> entry : countriesMap.entrySet()) {
            f.format("Country: %1$-20.20s Capital: %2$-20.20s \n", entry.getKey(), entry.getValue());
        }
        System.out.println("打印KeySet：");
        for (String name : countriesMap.keySet()) {
            f.format("Country: %1$-20.20s \n", name);
        }
    }
}
