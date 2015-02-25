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
        return 'CAFE > ' +id+' '+name+' '+city+' '+neighborhood
    }
}
