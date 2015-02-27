package com.pangio.cafe

class Cafe {

    String id
    String name
    String city
    String neighborhood

    static constraints = {
    }

    @Override
    String toString(){
        return String.format(
                "Cafe [id=%s, name='%s', city='%s', neighborhood='%s']",
                id, name, city, neighborhood);
    }
}
