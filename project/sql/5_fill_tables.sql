USE `website_hotels_db`;

INSERT INTO `hotels` (`id`, `admin_id`, `name`, `stars`, `type_of_food`, `type_of_allocation`, `type_of_comfort`,
                      `price_of_room`, `price_of_comfort`, `reward_for_tour_operator`, `parking`, `wifi`, `pets`,
                      `business_center`, `countries_id`, `city`, `street`, `house`)
VALUES (1, 1, 'Европа', 5, 31, 29, 15, '0011000135001500020000030', '000300030000100', 7, true, true, true, true,
        'BLR', 'Минск', 'ул. Интернациональная', 28);

INSERT INTO `rooms` (`hotel_id`, `number`, `type_of_allocation`, `type_of_comfort`)
VALUES (1, 1, 16, 8),
       (1, 2, 16, 8),
       (1, 3, 16, 8),
       (1, 4, 16, 8),
       (1, 5, 16, 8),
       (1, 6, 17, 8),
       (1, 7, 17, 8),
       (1, 8, 17, 8),
       (1, 9, 8, 8),
       (1, 10, 8, 8),
       (1, 11, 8, 8),
       (1, 12, 8, 8),
       (1, 13, 8, 8),
       (1, 14, 9, 8),
       (1, 15, 9, 8),
       (1, 16, 9, 8),
       (1, 17, 9, 8),
       (1, 18, 9, 8),
       (1, 19, 4, 8),
       (1, 20, 4, 8),
       (1, 21, 4, 8),
       (1, 22, 2, 4),
       (1, 23, 3, 4),
       (1, 24, 16, 2),
       (1, 25, 16, 2),
       (1, 26, 8, 2),
       (1, 27, 8, 2),
       (1, 28, 2, 2),
       (1, 29, 8, 1),
       (1, 30, 8, 1),
       (1, 31, 8, 1);