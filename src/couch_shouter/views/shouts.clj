(ns couch-shouter.views.shouts
  (:use [hiccup.core :only [html h]]
        [hiccup.page-helpers :only [doctype]]
        [hiccup.form-helpers :only [form-to label text-area submit-button]])
  (:require [couch-shouter.views.layout :as layout]))

(defn shout-form []
  [:div {:id "shout-form" }
   (form-to [:post "/"]
            (label "shout" "What do you want to SHOUT?")
            [:br]
            (text-area "shout")
            [:br]
            (submit-button "SHOUT!"))])

(defn display-shouts [shouts]
   [:div {:id "shouts"}
    [:ul
     (map
      (fn [shout] [:li (:data (:doc shout))])
      (:rows shouts))]])

(defn index [shouts]
  (layout/common "COUCH SHOUTER"
                 (shout-form)
                 [:br]
                 (display-shouts shouts)))
