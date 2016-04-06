(ns cssfun.core
  (:require
   #_[om.core :as om :include-macros true]
   [sablono.core :as sab :include-macros true]
   [cssfun.start])
  (:require-macros
   [devcards.core :as dc :refer [defcard deftest]]))

(enable-console-print!)

(defn- make-hiccup-name
  "Construct a hiccup keyword name from the supplied classes & ids"
  [& fragments]
  (keyword (apply str fragments)))

(defn- margin-note
  "Return the Hiccup for a margin note based on the supplied text and note id"
  [text note-id]
  [:label.margin-toggle.sidenote-number {:for note-id }]
  [(make-hiccup-name "input" "#" note-id "." "margin-toggle")]
  [:span.sidenote text])

(defcard margin-test
         (sab/html [:p
                    (str "We should see a hiccup node name constructed from the invented fragments: " (make-hiccup-name "input" "#" "test-id" "." "margin-toggle"))]))

(defcard first-card
  (sab/html [:article
             [:h1 "What I'm thinking about, and how I arrived here"]
             [:section
              [:p [:span.newthought "As I was sitting at my desk "]
               "I realised I had been sitting there for some time. Behind me, a man was humming along to the tinny racket his headphones were making."
               [:label.margin-toggle.sidenote-number {:for "sn-test" }]
               [:input#sn-test.margin-toggle]
               [:span.sidenote "I really like these side notes."]
               " I looked around and realised that he was staring vacantly at me as his head bobbed in time to whatever he was hearing. "]
              [:p "He realised with a start that I was looking at him - I mean, we were staring right at each other - and he had that fun experience we all have when we're caught unexpectedly in another's gaze. "]]]))

(defn main []
  ;; conditionally start the app based on whether the #main-app-area
  ;; node is on the page
  (if-let [node (.getElementById js/document "main-app-area")]
    (js/React.render (sab/html [:div "This is working"]) node)))

(main)

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/cards.html

