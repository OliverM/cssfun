(ns cssfun.core
  (:require
   #_[om.core :as om :include-macros true]
   [sablono.core :as sab :include-macros true]
   [reagent.core :as r]
   [cssfun.start])
  (:require-macros
   [devcards.core :as dc :refer [defcard deftest]]))

(enable-console-print!)

(defcard first-card
  (sab/html [:article
             [:h1 "What I'm thinking about, and how I arrived here"]
             [:section
              [:p [:span.newthought "As I was sitting at my desk "]
               "I realised I had been sitting there for some time. Behind me, a man was humming along to the tinny racket his headphones were making."
               [:label.margin-toggle.sidenote-number {:for "sidenote-1"}]
               [:input#sidenote-1.margin-toggle {:type "checkbox"}]
               [:span.sidenote "Here is some convenient side note text."]

               " I looked around and realised that he was staring vacantly at me as his head bobbed in time to whatever  he was hearing. "
               [:label.margin-toggle {:for "marginnote-1"} {:value "!"}]
               [:input#marginnote-1.margin-toggle {:type "checkbox"}]
               [:span.marginnote "Here's some more text, just as convenient and useful as before."]]
              [:p "He realised with a start that I was looking at him - I mean, we were staring right at each other - and he had that fun experience we all have when we're caught unexpectedly in another's gaze. "]]]))

(defn main []
  ;; conditionally start the app based on whether the #main-app-area
  ;; node is on the page
  (if-let [node (.getElementById js/document "main-app-area")]
    (js/React.render (sab/html [:span]) node)))

(main)

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/cards.html

