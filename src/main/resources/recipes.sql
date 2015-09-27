CREATE TABLE categories (
  id INTEGER PRIMARY KEY,
  keyword TEXT,
  name TEXT,
  created_at DATETIME, 
  updated_at DATETIME
);

CREATE TABLE recipes (
  id INTEGER PRIMARY KEY,
  category_id INTEGER,
  keyword TEXT,
  name TEXT,
  description TEXT,
  image TEXT,
  preparation TEXT,
  created_at DATETIME, 
  updated_at DATETIME
);

CREATE TABLE directions (
  id INTEGER PRIMARY KEY,
  recipe_id INTEGER,
  description TEXT,
  created_at DATETIME, 
  updated_at DATETIME
);

CREATE TABLE ingredients (
  id INTEGER PRIMARY KEY,
  recipe_id INTEGER,
  quantity TEXT,
  name TEXT,
  measurements TEXT,
  created_at DATETIME, 
  updated_at DATETIME
);
