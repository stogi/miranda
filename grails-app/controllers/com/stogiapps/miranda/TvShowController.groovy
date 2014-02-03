package com.stogiapps.miranda

import grails.transaction.Transactional

@Transactional(readOnly = true)
class TvShowController {

    def index() {
        [tvShows: TvShow.list()]
    }

    def add() {
        [tvShow: new TvShow()]
    }

    def edit(TvShow tvShow) {
        if (!tvShow) {
            notFound()
            return
        }
        [tvShow: tvShow]
    }

    @Transactional
    def save(TvShow tvShow) {
        if (!tvShow) {
            notFound()
            return
        }

        boolean isNew = !tvShow.id ? true : false

        if (tvShow.hasErrors()) {
            render view: isNew ? 'add' : 'edit', model: [tvShow: tvShow]
            return
        }

        tvShow.save()

        flash.message = [code: "default.${isNew ? 'added' : 'edited'}.message", args: [tvShow.name]]

        redirect action: 'index'
    }

    @Transactional
    def delete(TvShow tvShow) {
        if (!tvShow) {
            notFound()
            return
        }

        tvShow.delete()

        flash.message = [code: 'default.deleted.message', args: [tvShow.name]]

        redirect action: 'index'
    }

    private void notFound() {
        flash.message = [code: 'default.not.found.message', args: [params.id]]

        redirect action: 'index'
    }
}
