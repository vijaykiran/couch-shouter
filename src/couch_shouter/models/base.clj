(ns couch-shouter.models.base
  (:require [clojure.string :as str]
            [com.ashafa.clutch :as clutch])
  (:import (java.net URI)))

(defn database-resource []
  (let [url (URI. (System/getenv "CLOUDANT_URL"))
        host (.getHost url)
        port (if (pos? (.getPort url)) (.getPort url) 443)]
    (merge
     {:host host}
     {:port port}
     {:language "Clojure"}
     (if-let [user-info (.getUserInfo url)]
       {:user (first (str/split user-info #":"))
        :password (second (str/split user-info #":"))}))))


(defn db []
  (clutch/set-clutch-defaults! (database-resource))
  (clutch/get-database "couch-shouter"))
