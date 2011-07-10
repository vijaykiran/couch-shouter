(ns couch-shouter.models.shout
  (:use [couch-shouter.models.base :only [db]])
  (:require [com.ashafa.clutch :as clutch]))

(defn all []
  (clutch/with-db (db)
    (->> (clutch/get-all-documents-meta)
         :rows
         (map :id :data))))

(defn create []
  )
