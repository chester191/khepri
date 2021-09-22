(ns khepri-reframe.views
  (:require
   [re-frame.core :as re-frame]
   [khepri-reframe.subs :as subs]
   [khepri-reframe.events :as events]))

(defn display-product [product]
  [:div.product
   [:img {:src "images/screen-0.jpg"
          :on-click #(re-frame/dispatch [::events/change-view "product-detail"])}]
   [:p product]])


(defn products []
  (let [products (re-frame/subscribe [::subs/products])]
    [:div
     [:div.product-heading
      [:h2 "Our Products"]
      [:h3 "Small write up about products"]]
     [:div.shop
      [:div.filter
       [:a {:on-click #(re-frame/dispatch [::events/change-filter "All"]) :id "All-filter"} "All"]
       [:a {:on-click #(re-frame/dispatch [::events/change-filter "Live feed"]) :id "Live-feed-filter"} "Live feed"]
       [:a {:on-click #(re-frame/dispatch [::events/change-filter "Dried Insects"]) :id "Dried-Insects-filter"} "Dried Insects"]
       [:a {:on-click #(re-frame/dispatch [::events/change-filter "Full feed"]) :id "Full-feed-filter"} "Full feed"]
       [:a {:on-click #(re-frame/dispatch [::events/change-filter "Khepri Bioconversion Units"]) :id "Khepri-Bioconversion-Units-filter"} "Khepri Bioconversion Units"]]
      [:div.product-grid
       (map display-product @products)]]]))

(defn product-detail []
  [:div
  [:div.product-detail-grid
   [:div.product-detail-wrapper
    [:img {:src "images/screen-0.jpg"}]
    [:p "product"]]
   [:div
    [:h2 "Khepri Meal"]
    [:p "Khepri Meal™ consists of highly nutritious dried defatted" [:br]
     "larvae that are ground into a high protein meal"]
    [:button "Add to cart"]]
   [:br]
   [:div
    [:h3 "Product Specification:"]
    [:p "Crude protein (min) 400 g/kg" [:br]
     "Moisture (max) 100 g/kg" [:br]
     "Crude fiber (max) 121 g/kg" [:br]
     "Crude Fat (max) 100 g/kg" [:br]
     "Calcium (max) 5 g/kg" [:br]
     "Phosphorus (max) 30 g/kg"]]

;;     Preparation: 
;; Our larvae are sterilised and then dried under strict conditions at a very low heat to yield the highest quality protein. The protein contents of the final product are higher than whole dried larvae and have a low fat content.

;; Appearance:
;; Khepri Meal™ Dark rich texture with a slightly nutty flavour. Product can be supplied pelleted, crushed or milled for blending into animal feeds.

;; Use: 
;; Khepri Meal™ can be blended into a variety of animal feeds and used just like any other protein such as fishmeal its nearest nutritional equivalent. It is specifically useful for the feeding of monogastric animals including chickens, pigs and fish

;; Storage: 
;; Store at ambient preferably below 25C out of direct sunlight, keep away from moisture. Shelf life is 12 months from date of production.
   ][:div.product-detail-description
     [:h3 "Preparation:"]
[:p "Our larvae are sterilised and then dried under strict conditions at a very low heat to yield the highest quality protein. The protein contents of the final product are higher than whole dried larvae and have a low fat content."]
[:h3 "Appearance:"]
[:p "Khepri Meal™ Dark rich texture with a slightly nutty flavour. Product can be supplied pelleted, crushed or milled for blending into animal feeds."]
[:h3 "Use:"]
[:p "Khepri Meal™ can be blended into a variety of animal feeds and used just like any other protein such as fishmeal its nearest nutritional equivalent. It is specifically useful for the feeding of monogastric animals including chickens, pigs and fish"]
[:h3 "Storage"]
[:p "Store at ambient preferably below 25C out of direct sunlight, keep away from moisture. Shelf life is 12 months from date of production."]]])
  

;; (defn product []
;;   (let [products (re-frame/subscribe [::subs/products])
;;         view (re-frame/subscribe [::subs/product-view])]
;;     [:h2 "focus: " @view]
;;     ;; (case @view "products" (products)
;;     ;;        (product-detail))
;;     (products)))


(defn display-services [service]
  [:div.service
   [:img {:src "images/screen-0.jpg"}]
   [:p service]])

(defn services []
  (let [services (re-frame/subscribe [::subs/services])]
    [:div
     [:div.service-sub-heading
      [:h2 "Our Services"]
      [:h3 "Our passion for a greener more sustainable South Africa 
          has lead us to spread knowledge and provide 
          assistance in areas regarding the proper waste management 
          and disposal. We therefore consult with various partners and 
          customers within the butchery and abattoir sectors regarding 
          efficient and proper disposal of wastes."]]
     [:div.service-grid
      (map display-services @services)
      [:div
       [:h4 "Levels"]
       [:p "Beginner 2 days"]
       [:p "Intermediate 2 weeks"]
       [:p "Advanced 5 weeks"]]]]))



(defn home-page []
  [:div.homepage
   [:div
    [:img.bck {:src "images/background.jpeg"}]
    [:p.sub-title "Top bioconversion research and sustainable animal feed producers"]
    [:a.products-anchor "See our products"]]


   [:div.page1
    [:p "We combine principles and technologies from a multitude of spheres including: industrial entomology, engineering, agriculture and biotechnology.
           By merging such diverse yet specialized expertise, together with fresh entrepreneurial ideas and commercial creativity, 
           we strive to solve various problems in the agricultural, health and research sectors in an economically viable way."]
    [:div.image-container
     [:img {:src "images/background(1).jpeg"}]
     [:h2 ;Research
      "Research"]
     [:h3 ;res-subheading
      "The research and patenting of indigenous knowledge solutions"]]]



   [:div.page2
    [:h1 "Our services"]
    [:p.services-heading "We design, implement, and market modular insect bioconversion units for the production of insect based protein and fertilizer from organic waste."]
    [:div.services-row
     [:img {:src "images/group_icon.png"}]
     [:img {:src "images/project_icon.png"}]
     [:img {:src "images/research_icon.png"}]
     [:img {:src "images/waste_icon.png"}]]
    [:div.services-row
     [:p.services-text "Consulting & Training Services"]
     [:p.services-text "Project Management Services"]
     [:p.services-text "Research & Development"]
     [:p.services-text "Abattoir Waste Collection & Treatment"]]
    [:div.more-info
     [:a.more-info-text "Tell me more"]]]
   [:div.page3
    [:h1.our-partners "Our partners"]
    [:div.partners-grid
     [:img.partner-icon {:src "images/egoliBio.png"}]
     [:img.partner-icon {:src "images/enactus.png"}]
     [:img.partner-icon {:src "images/maxum.png"}]
     [:img.partner-icon {:src "images/technoserve.png"}]
     [:img.partner-icon {:src "images/khepri.png"}]]
    [:div.partners-grid
     [:img.partner-icon {:src "images/SAdti.png"}]
     [:img.partner-icon {:src "images/SAB.png"}]
     [:img.partner-icon {:src "images/DIAGEO.png"}]
     [:img.partner-icon {:src "images/tech_inovation_agency.png"}]
     [:img.partner-icon {:src "images/CSIR.png"}]]
    [:div.award
     [:h1 "Award"]
     [:p "Finalist in the Makers of More: Your Idea, Your Community, Your Action challenge! -2015"]]]])

(defn contact []
  [:div
   [:div.contact-heading
    [:h2 "Contact us"]
    [:h3 "Send us a message and we'll get back to you as soon as we can"]]
   [:form
    [:input {:type "text"
             :name "full-name"
             :placeholder "Full name"
             :value ""}]
    [:input {:type "email"
             :name "Email"
             :placeholder "Email address"
             :value ""}]
    [:input {:type "text"
             :name "Subject"
             :placeholder "Subject"
             :value ""}]
    [:textarea {:name "comment"
                :placeholder "Type message here..."
                :rows "8"
                :cols "80"}]
    [:input.submit-button {:class "submit"
                           :type "submit"
                           :value "Submit"}]]])
(defn cart []
  [:div.cart
   [:h1 "My cart"]
   [:p "Please make sure the items 
       listed beow are correct before you proceed to checkout"]
   [:div.list
    [:table
     [:tr
      [:th [:div.cart-Product "Product"]]
      [:th "Qunatity"]
      [:th "Cost"]]
     [:tr.cart-product
      [:td [:div.cart-Product "Khepri Meal"]]
      [:td [:div.quantity [:button "<"] "1" [:button ">"]]]
      [:td.price "R 100.00"]]
     [:tr.cart-product
      [:td [:div.cart-Product "Khepri Meal"]]
      [:td [:div.quantity [:button "<"] "2" [:button ">"]]]
      [:td.price "R 250.00"]]
     [:tr
      [:td]
      [:td.total-line
       ;[:hr]"place holder"
       ]

      [:td  [:hr] "Total Cost"]]
     [:tr
      [:td]
      [:td]
      [:td.total "R 350.00"]]]]
   [:input.checkout-button {:type "submit"
                            :value "checkout"}]])

(defn checkout []
  [:div ;thank-you note
   [:h2 "Thank you for buying from us"]
   [:p "Your order was purchased successfully.
        An email receipt has been be sent to you 
        outlining the details of your purchase."]])


(defn display-quote [p]
  [:li p])

(defn display-quote-product [qp]
  [:option qp])

(defn get-quote []
  (let [quote (re-frame/subscribe [::subs/quote])
        ;;  quote-products (re-frame/subscribe [::subs/quote-products])
        ]
    [:div.quote-heading
     [:h2 "Get a quote"]
     [:h3 "Fill in our quote form and we'll get back to you within 48 hours."]
     [:form {:action "index.html"
             :method "post"}
      [:input {:type "text"
               :name "full-name"
               :placeholder "Full name"
               :value ""}]
      [:input {:type "text"
               :name "cellphone"
               :placeholder "Cellphone number"
               :value ""}]
      [:input {:type "email"
               :name "Email"
               :placeholder "Email address"
               :value ""}]

      [:select {:id "products"
                :name "products"}
       [:option "Select a product"]
       (map display-quote-product @quote)]

      [:div.add-product
       [:button "+"]
       [:p "Add product"]]
      [:ul
       (map display-quote @quote)]
      [:textarea {:name "comment"
                  :placeholder "Leave a comment..."
                  :rows "8"
                  :cols "80"}]
      [:input.submit-button {:class "submit"
                             :type "submit"
                             :value "Send"}]]]))

(defn panel []
  (let [view-focus (re-frame/subscribe [::subs/view-focus])]
    [:h2 "focus: " @view-focus]
    (case @view-focus "products" (products)
          "product-detail" (product-detail)
          "services" (services)
          "contact" (contact)
          "quote" (get-quote)
          "cart" (cart)
          "checkout" (checkout)
          (home-page))))

(defn footer[]
  (let [view-focus (re-frame/subscribe [::subs/view-focus])]
  (case @view-focus "home" nil
    [:div.footer
     [:div.contact
      [:p "Cell: +27 83 253 9431" 
       [:br]
       " Email: info@khepri.co.za"]
      
      [:img {:src "images/khepri.png"}]
      [:p "Based in Gauteng," 
       [:br]
       "South Africa since 2012"]]
     [:div.copyright
      [:p "Copyright © Khepri"]]])))

(defn main-panel []
  [:div
   [:nav.navigation {:id "nav-bar"}
    [:a {:on-click #(re-frame/dispatch [::events/change-view "home"]) :id "home-anchor"} "Home"]
    [:a {:on-click #(re-frame/dispatch [::events/change-view "products"])} "Products"]
    [:a {:on-click #(re-frame/dispatch [::events/change-view "services"])} "Services"]
    [:a {:on-click #(re-frame/dispatch [::events/change-view "contact"])} "Contact"]
    [:h1 "KHEPRI"]
    [:a {:on-click #(re-frame/dispatch [::events/change-view "quote"])} "Get a quote"]
    [:a {:on-click #(re-frame/dispatch [::events/change-view "cart"])} "My cart"]]
   (panel)
   (footer)])





