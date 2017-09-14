(ns eem-dashboards.core
    (:require [dashboard-clj.core :as d]
              [dashboard-clj.layouts.grid-layout-responsive :as grid]
              [eem-dashboards.widgets.simple-text]
              [eem-dashboards.widgets.server-status]))

(def widgets [

              ;{:type        :simple-text
              ; :name        :sample-widget
              ; :data-source :welcome-message
              ; :options     {}}
              {:type        :simple-text
               :name        :time-widget
               :data-source :current-time
               :options     {}}
              {:type        :server-status-card
               :name        :skyros
               :data-source :server-status
               :options     {}}])

(def widget-layout {:skyros        {:layout-opts {:position {:lg {:x 0 :y 0 :w 2 :h 2}
                                                             :md {:x 0 :y 0 :w 2 :h 2}
                                                             :sm {:x 0 :y 0 :w 2 :h 2 :static true}}}}
                    ;:sample-widget {:layout-opts {:position {:lg {:x 0 :y 0 :w 2 :h 2}
                    ;                                         :md {:x 0 :y 0 :w 2 :h 2}
                    ;                                         :sm {:x 0 :y 0 :w 2 :h 2 :static true}}}}
                    :time-widget   {:layout-opts {:position {:lg {:x 2 :y 0 :w 2 :h 2}
                                                             :md {:x 2 :y 0 :w 2 :h 2}
                                                             :sm {:x 0 :y 2 :w 2 :h 2 :static true}}}}})


(def dashboard {
                :layout  :responsive-grid-layout
                :options {:layout-opts {:cols {:lg 6 :md 4 :sm 2 :xs 1 :xxs 1}}}
                :widgets (mapv #(merge % (get widget-layout (:name %))) widgets)})


(d/start-dashboard dashboard "app")
