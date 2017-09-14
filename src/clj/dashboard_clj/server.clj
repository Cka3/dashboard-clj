(ns eem-dashboards.server
    (:require [dashboard-clj.core :as dash]
              [environ.core :refer [env]]
              [eem-dashboards.fetcher])
    (:gen-class))

(def datasources [{:name     :welcome-message
                   :read-fn  :eem-dashboards.fetcher/fetch}
                  {:name     :current-time
                   :read-fn  :eem-dashboards.fetcher/current-time
                   :params   []
                   :schedule {:in    [0 :seconds]
                              :every [5 :seconds]}}
                  {:name     :server-status
                   :read-fn  :eem-dashboards.fetcher/server-status
                   :params   []
                   :schedule {:in    [0 :seconds]
                              :every [20 :seconds]}}])

(defn start-dashboard[]
  (dash/start datasources {:port (Integer. (or (env :port) 5000))}))

(defn -main [& [port]]
  (start-dashboard))
