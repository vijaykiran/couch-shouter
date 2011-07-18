(ns couch-shouter.models.shout
  (:use [couch-shouter.models.base :only [db]])
  (:require [com.ashafa.clutch :as clutch]))

(defn all []
  (clutch/with-db (db)
    (clutch/get-all-documents-meta {:include_docs true})))

(defn create [])
