# Cafe rest client 

Check out also the [Restful API](https://github.com/pangio/grails-cafe-restful-api) consumed by this rest client.
Note this is a Grails app - not a plugin.



# Stack
*  Grails 2.4.3
*  [rest-client-plugin](https://github.com/grails-plugins/grails-rest-client-builder) plugin

# Prerequisites
*  Grails 2.4.3
*  MySQL 5 (required by the [API](https://github.com/pangio/grails-cafe-restful-api) )


# Setup

First setup the [API](https://github.com/pangio/grails-cafe-restful-api).

Then clone the repo ``` https://github.com/pangio/grails-cafe-rest-client ```.

# Run the client

Build / run ``` grails compile``` and ```grails run-app -Dserver.port=8090```

That's it! [browse the app](http://localhost:8090/cafe-client/)

NOTE:
Is required to explicitly set another server port like is shown above.
Otherwise ```grails``` by default would attempt to run the client on the ```8080``` port which is already in use by the [API](https://github.com/pangio/grails-cafe-restful-api).

