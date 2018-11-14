(ns oc-battleships.coordinates)

(defn ship-coordinates
  "Calculates all the coordinates for a ship
  Takes a `tuple` for start location the `size` of the ship and the `orientation`"
  [[row col] size orientation]
  (case orientation
    :vertical (for [z (range size)] [z 0])
    [[0 0] [0 1] [0 2]]))
