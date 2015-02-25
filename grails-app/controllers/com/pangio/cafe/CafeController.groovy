package com.pangio.cafe

import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional
import org.apache.commons.logging.LogFactory

@Transactional(readOnly = true)
class CafeController {

    private static final log = LogFactory.getLog(this)

    def rest = new RestBuilder(connectTimeout:1000, readTimeout:20000, proxy:['localhost':8080])
    def url = "http://localhost:8080/cafe-api/cafes"

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)

        log.info('Getting the list of Cafes.')
        def response = rest.get(url)
        log.info('Response Http Status: ' + response.status)

        if (response.status != 200) {
            render view: '/error' , flash.message = message(code: 'error.getting.all.cafes', default: 'Error getting all the Cafes')
        }

        def cafeInstanceList = new ArrayList()
        response.json.each {
            def cafe = new Cafe (it)
            cafe.id = it.id
            cafeInstanceList.add(cafe)
        }
        respond cafeInstanceList
    }

    def show(Long id) {
        // TODO Refactor. Avoid unnecessary requests to the API and use the entity available on the client side

        log.info('Getting the Cafe.')
        def response = rest.get(url + "/" + params.id)
        log.info('Response Http Status: ' + response.status + ' - JSON > '+ response.text)

        if (response.status != 200) {
            render view: '/error' , flash.message = message(code: 'error.getting.cafe', default: 'Error getting the Cafe')
        }

        def cafeInstance = new Cafe(response.json)
        cafeInstance.id = params.id
        respond cafeInstance, params
    }

    def create() {
        log.info('Creating a Cafe.')
        respond new Cafe(params)
    }

    @Transactional
    def save() {
        // TODO Refactor. Avoid unnecessary requests to the API and use the entity available on the client side

        log.info('Saving the new Cafe into the DB.')
        def response = rest.post(url){
            json name: params.name, city: params.city, neighborhood: params.neighborhood
        }
        log.info('Response Http Status: ' + response.status)

        if (response.status != 201) {
            render view: '/error' , flash.message = message(code: 'error.creating.cafe', default: 'Error saving the Cafe')
        }

        def cafeInstance = new Cafe(response.json)
        cafeInstance.id = response.json.id
        flash.message = message(code: 'notification.cafe.created', default: 'Cafe '+ cafeInstance.name +' created')
        redirect action: "show", id: cafeInstance.id
    }

    def edit() {
        // TODO Refactor. Avoid unnecessary requests to the API and use the entity available on the client side

        log.info('Editing Cafe.')
        def response = rest.get(url + "/" + params.id)

        if (response.status != 200) {
            render view: '/error' , flash.message = message(code: 'error.editing.cafe', default: 'Error editing the Cafe')
        }

        def cafeInstance = new Cafe(response.json)
        cafeInstance.id = params.id
        respond cafeInstance
    }

    @Transactional
    def update() {
        log.info('Updating the Cafe.')
        def response = rest.put(url + '/' + params.id){
            json name: params.name, city: params.city, neighborhood: params.neighborhood
        }
        log.info('Response Http Status: ' + response.status)

        if (response.status != 200) {
            render view: '/error' , flash.message = message(code: 'error.updating.cafe', default: 'Error updating the Cafe')
        }

        def cafeInstance = new Cafe(response.json)
        cafeInstance.id = params.id
        flash.message = message(code: 'notification.cafe.updated', default: 'Cafe '+ cafeInstance.name +' updated')
        redirect(action: "show", id: cafeInstance.id)
    }

    @Transactional
    def delete() {
        log.info('Deleting the Cafe.')
        def response = rest.delete(url + "/" + params.id)
        log.info('Response Http Status: ' + response.status + ' - '+ response.text)

        if (response.status != 204) {
            render view: '/error' , flash.message = message(code: 'error.deleting.cafe', default: 'Error deleting the Cafe')
        }
        flash.message = message(code: 'notification.cafe.deleted', default: 'Cafe '+ params.id+' deleted')
        redirect action:"index"
    }
}