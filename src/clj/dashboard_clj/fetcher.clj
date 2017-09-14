(ns eem-dashboards.fetcher
  (:require [eem-dashboards.ssh :refer :all]))

(defn fetch []
  {:title "Welcome"
   :text "Illya3"})

(defn current-time []
  {:title "Tiime"
   :text  (.format (java.time.LocalDateTime/now) (java.time.format.DateTimeFormatter/ofPattern "hh:mm:ss"))})

(defn server-status []
   (kak-dela :skyros))
