(ns sthenos.hercules.specs.exercise
  (:require [clojure.spec.alpha :as s]
            [sthenos.hercules.validations.exercise :as validations.exercise]))

(s/def :exercise/name #{:burpee
                        :burpee-jump
                        :sprawl
                        :squat})

(s/def :exercise/description
  (s/and string? (validations.exercise/min-length? :exercise/description)))

(s/def :exercise/movement
  (s/keys :req [:exercise/name
                :exercise/description
                :exercise/type
                :exercise/difficulty
                :exercise/variants
                (or :exercise/reps :exercise/duration)]))

(def burpee-example-movement
  #:exercise {:name        :burpee
              :description "Burpees"
              :reps        20
              :type        :total-body
              :difficulty  :intermediate
              :variants    {:beginner :sprawl
                            :advanced :burpee-jump}})
