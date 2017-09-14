(ns eem-dashboards.widgets.server-status
    (:require [reagent.core :as r :refer [atom]]
      [dashboard-clj.widgets.core :as widget-common]))

(defonce gui-state (r/atom {}))

(defn gen-key []
  (gensym "key-"))

(defn process-list-to-nodes
  "This will take process list from status function and make hickup "
  [process-list]
  (let [parts (partition-all 5 process-list)]
    [:div {:class "iblock"}
     (for [row parts]
       ^{:key (gen-key)}
       [:div {:class "iblock"}
        (for [process-node row]
          ^{:key (gen-key)}
          [:div {:class (str "process-node " (if (:running? process-node) "green" "red"))}])])]))


(widget-common/register-widget
  :server-status-card
  (fn [data options]
    [:div
     [:div {:class "title-wrapper"}
      [:h3 {:class "title"} (str (get-in data [:data :server-name]))]]

     (process-list-to-nodes (get-in data [:data :app-status]))]))

(widget-common/register-widget
  :server-info
  (fn [data options]))

