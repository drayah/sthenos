(ns sthenos.hercules.domain.validations)

(def min-lengths {:exercise/description 3})

(defn min-length? [attribute]
  #(>= (count %) (min-lengths attribute)))
