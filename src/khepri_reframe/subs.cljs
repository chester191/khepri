(ns khepri-reframe.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::view-focus
 (fn [db]
   (:view-focus db)))

(re-frame/reg-sub
 ::product-view
 (fn [db]
   (:product-view db)))

(re-frame/reg-sub
 ::products
 (fn [db]
   (:products db)))

(re-frame/reg-sub
 ::quote
 (fn [db]
   (:quote db)))

(re-frame/reg-sub
 ::quote-products
 (fn [db]
   (:quote-products db)))


(re-frame/reg-sub
 ::services
 (fn [db]
   (:services db)))