USE `website_hotels_db`;

INSERT INTO `countries` (`Code`, `Name`)
VALUES ('ABW', 'Aruba'),
       ('AFG', 'Afghanistan'),
       ('AGO', 'Angola'),
       ('AIA', 'Anguilla'),
       ('ALB', 'Albania'),
       ('AND', 'Andorra'),
       ('ANT', 'Netherlands Antilles'),
       ('ARE', 'United Arab Emirates'),
       ('ARG', 'Argentina'),
       ('ARM', 'Armenia'),
       ('ASM', 'American Samoa'),
       ('ATA', 'Antarctica'),
       ('ATF', 'French Southern territories'),
       ('ATG', 'Antigua and Barbuda'),
       ('AUS', 'Australia'),
       ('AUT', 'Austria'),
       ('AZE', 'Azerbaijan'),
       ('BDI', 'Burundi'),
       ('BEL', 'Belgium'),
       ('BEN', 'Benin'),
       ('BFA', 'Burkina Faso'),
       ('BGD', 'Bangladesh'),
       ('BGR', 'Bulgaria'),
       ('BHR', 'Bahrain'),
       ('BHS', 'Bahamas'),
       ('BIH', 'Bosnia and Herzegovina'),
       ('BLR', 'Belarus'),
       ('BLZ', 'Belize'),
       ('BMU', 'Bermuda'),
       ('BOL', 'Bolivia'),
       ('BRA', 'Brazil'),
       ('BRB', 'Barbados'),
       ('BRN', 'Brunei'),
       ('BTN', 'Bhutan'),
       ('BVT', 'Bouvet Island'),
       ('BWA', 'Botswana'),
       ('CAF', 'Central African Republic'),
       ('CAN', 'Canada'),
       ('CCK', 'Cocos (Keeling) Islands'),
       ('CHE', 'Switzerland'),
       ('CHL', 'Chile'),
       ('CHN', 'China'),
       ('CIV', 'CÃ´te dÂ’Ivoire'),
       ('CMR', 'Cameroon'),
       ('COD', 'Congo, The Democratic Republic of the'),
       ('COG', 'Congo'),
       ('COK', 'Cook Islands'),
       ('COL', 'Colombia'),
       ('COM', 'Comoros'),
       ('CPV', 'Cape Verde'),
       ('CRI', 'Costa Rica'),
       ('CUB', 'Cuba'),
       ('CXR', 'Christmas Island'),
       ('CYM', 'Cayman Islands'),
       ('CYP', 'Cyprus'),
       ('CZE', 'Czech Republic'),
       ('DEU', 'Germany'),
       ('DJI', 'Djibouti'),
       ('DMA', 'Dominica'),
       ('DNK', 'Denmark'),
       ('DOM', 'Dominican Republic'),
       ('DZA', 'Algeria'),
       ('ECU', 'Ecuador'),
       ('EGY', 'Egypt'),
       ('ERI', 'Eritrea'),
       ('ESH', 'Western Sahara'),
       ('ESP', 'Spain'),
       ('EST', 'Estonia'),
       ('ETH', 'Ethiopia'),
       ('FIN', 'Finland'),
       ('FJI', 'Fiji Islands'),
       ('FLK', 'Falkland Islands'),
       ('FRA', 'France'),
       ('FRO', 'Faroe Islands'),
       ('FSM', 'Micronesia, Federated States of'),
       ('GAB', 'Gabon'),
       ('GBR', 'United Kingdom'),
       ('GEO', 'Georgia'),
       ('GHA', 'Ghana'),
       ('GIB', 'Gibraltar'),
       ('GIN', 'Guinea'),
       ('GLP', 'Guadeloupe'),
       ('GMB', 'Gambia'),
       ('GNB', 'Guinea-Bissau'),
       ('GNQ', 'Equatorial Guinea'),
       ('GRC', 'Greece'),
       ('GRD', 'Grenada'),
       ('GRL', 'Greenland'),
       ('GTM', 'Guatemala'),
       ('GUF', 'French Guiana'),
       ('GUM', 'Guam'),
       ('GUY', 'Guyana'),
       ('HKG', 'Hong Kong'),
       ('HMD', 'Heard Island and McDonald Islands'),
       ('HND', 'Honduras'),
       ('HRV', 'Croatia'),
       ('HTI', 'Haiti'),
       ('HUN', 'Hungary'),
       ('IDN', 'Indonesia'),
       ('IND', 'India'),
       ('IOT', 'British Indian Ocean Territory'),
       ('IRL', 'Ireland'),
       ('IRN', 'Iran'),
       ('IRQ', 'Iraq'),
       ('ISL', 'Iceland'),
       ('ISR', 'Israel'),
       ('ITA', 'Italy'),
       ('JAM', 'Jamaica'),
       ('JOR', 'Jordan'),
       ('JPN', 'Japan'),
       ('KAZ', 'Kazakstan'),
       ('KEN', 'Kenya'),
       ('KGZ', 'Kyrgyzstan'),
       ('KHM', 'Cambodia'),
       ('KIR', 'Kiribati'),
       ('KNA', 'Saint Kitts and Nevis'),
       ('KOR', 'South Korea'),
       ('KWT', 'Kuwait'),
       ('LAO', 'Laos'),
       ('LBN', 'Lebanon'),
       ('LBR', 'Liberia'),
       ('LBY', 'Libyan Arab Jamahiriya'),
       ('LCA', 'Saint Lucia'),
       ('LIE', 'Liechtenstein'),
       ('LKA', 'Sri Lanka'),
       ('LSO', 'Lesotho'),
       ('LTU', 'Lithuania'),
       ('LUX', 'Luxembourg'),
       ('LVA', 'Latvia'),
       ('MAC', 'Macao'),
       ('MAR', 'Morocco'),
       ('MCO', 'Monaco'),
       ('MDA', 'Moldova'),
       ('MDG', 'Madagascar'),
       ('MDV', 'Maldives'),
       ('MEX', 'Mexico'),
       ('MHL', 'Marshall Islands'),
       ('MKD', 'Macedonia'),
       ('MLI', 'Mali'),
       ('MLT', 'Malta'),
       ('MMR', 'Myanmar'),
       ('MNG', 'Mongolia'),
       ('MNP', 'Northern Mariana Islands'),
       ('MOZ', 'Mozambique'),
       ('MRT', 'Mauritania'),
       ('MSR', 'Montserrat'),
       ('MTQ', 'Martinique'),
       ('MUS', 'Mauritius'),
       ('MWI', 'Malawi'),
       ('MYS', 'Malaysia'),
       ('MYT', 'Mayotte'),
       ('NAM', 'Namibia'),
       ('NCL', 'New Caledonia'),
       ('NER', 'Niger'),
       ('NFK', 'Norfolk Island'),
       ('NGA', 'Nigeria'),
       ('NIC', 'Nicaragua'),
       ('NIU', 'Niue'),
       ('NLD', 'Netherlands'),
       ('NOR', 'Norway'),
       ('NPL', 'Nepal'),
       ('NRU', 'Nauru'),
       ('NZL', 'New Zealand'),
       ('OMN', 'Oman'),
       ('PAK', 'Pakistan'),
       ('PAN', 'Panama'),
       ('PCN', 'Pitcairn'),
       ('PER', 'Peru'),
       ('PHL', 'Philippines'),
       ('PLW', 'Palau'),
       ('PNG', 'Papua New Guinea'),
       ('POL', 'Poland'),
       ('PRI', 'Puerto Rico'),
       ('PRK', 'North Korea'),
       ('PRT', 'Portugal'),
       ('PRY', 'Paraguay'),
       ('PSE', 'Palestine'),
       ('PYF', 'French Polynesia'),
       ('QAT', 'Qatar'),
       ('REU', 'RÃ©union'),
       ('ROM', 'Romania'),
       ('RUS', 'Russian Federation'),
       ('RWA', 'Rwanda'),
       ('SAU', 'Saudi Arabia'),
       ('SDN', 'Sudan'),
       ('SEN', 'Senegal'),
       ('SGP', 'Singapore'),
       ('SGS', 'South Georgia and the South Sandwich Islands'),
       ('SHN', 'Saint Helena'),
       ('SJM', 'Svalbard and Jan Mayen'),
       ('SLB', 'Solomon Islands'),
       ('SLE', 'Sierra Leone'),
       ('SLV', 'El Salvador'),
       ('SMR', 'San Marino'),
       ('SOM', 'Somalia'),
       ('SPM', 'Saint Pierre and Miquelon'),
       ('STP', 'Sao Tome and Principe'),
       ('SUR', 'Suriname'),
       ('SVK', 'Slovakia'),
       ('SVN', 'Slovenia'),
       ('SWE', 'Sweden'),
       ('SWZ', 'Swaziland'),
       ('SYC', 'Seychelles'),
       ('SYR', 'Syria'),
       ('TCA', 'Turks and Caicos Islands'),
       ('TCD', 'Chad'),
       ('TGO', 'Togo'),
       ('THA', 'Thailand'),
       ('TJK', 'Tajikistan'),
       ('TKL', 'Tokelau'),
       ('TKM', 'Turkmenistan'),
       ('TMP', 'East Timor'),
       ('TON', 'Tonga'),
       ('TTO', 'Trinidad and Tobago'),
       ('TUN', 'Tunisia'),
       ('TUR', 'Turkey'),
       ('TUV', 'Tuvalu'),
       ('TWN', 'Taiwan'),
       ('TZA', 'Tanzania'),
       ('UGA', 'Uganda'),
       ('UKR', 'Ukraine'),
       ('UMI', 'United States Minor Outlying Islands'),
       ('URY', 'Uruguay'),
       ('USA', 'United States'),
       ('UZB', 'Uzbekistan'),
       ('VAT', 'Holy See (Vatican City State)'),
       ('VCT', 'Saint Vincent and the Grenadines'),
       ('VEN', 'Venezuela'),
       ('VGB', 'Virgin Islands, British'),
       ('VIR', 'Virgin Islands, U.S.'),
       ('VNM', 'Vietnam'),
       ('VUT', 'Vanuatu'),
       ('WLF', 'Wallis and Futuna'),
       ('WSM', 'Samoa'),
       ('YEM', 'Yemen'),
       ('YUG', 'Yugoslavia'),
       ('ZAF', 'South Africa'),
       ('ZMB', 'Zambia'),
       ('ZWE', 'Zimbabwe');

INSERT INTO `users` (`id`, `email`, `password`, `role`)
VALUES (1, 'admin@gmail.com', '21232F297A57A5A743894A0E4A801FC3', 0);

INSERT INTO `users_info`(`user_id`, `name`, `surname`, `middle_name`, `phone`, `passport`, `date_of_birthday`, `sex`,
                         `code_country`)
VALUES (1, 'Иванов', 'Сергей', 'Викторович', '375333339900', 'MP2222123', '1970-06-06', 0,
        'BLR');

