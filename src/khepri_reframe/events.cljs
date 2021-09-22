(ns khepri-reframe.events
  (:require
   [re-frame.core :as re-frame]
   [khepri-reframe.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))


(re-frame/reg-event-db
 ::initialize-db
 (fn-traced []
            db/default-db))



(defn ^:export set-white [elem-id]
  (let [elem        (js/document.getElementById elem-id)
        style       (.-style elem)
        new-color "white"]
    (set! (.-color style) new-color)))

(defn ^:export set-green [elem-id]
  (let [elem        (js/document.getElementById elem-id)
        style       (.-style elem)
        new-color "#42542C"]
    (set! (.-color style) new-color)))

;; (re-frame/reg-event-db
;;  ::change-filter
;;  (fn [db [_ val]]

;;    (if (= val "home")
;;      (set-white "nav-bar")
;;      (set-green "nav-bar"))

;;    (assoc db :filter val)))

(re-frame/reg-event-db
 ::change-view
 (fn [db [_ val]]

   (if (= val "home")
     (set-white "nav-bar")
     (set-green "nav-bar"))

   (assoc db :view-focus val))) 

