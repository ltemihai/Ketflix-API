CREATE TABLE users (
                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                       email TEXT NOT NULL UNIQUE,
                       password_hash TEXT NOT NULL,
                       display_name TEXT,
                       avatar_url TEXT,
                       is_2fa_enabled BOOLEAN DEFAULT FALSE,
                       totp_secret TEXT,
                       created_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
                       updated_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);

CREATE TABLE genres (
                        id SERIAL PRIMARY KEY,
                        name TEXT NOT NULL UNIQUE
);

CREATE TABLE user_genres (
                             user_id UUID REFERENCES users(id) ON DELETE CASCADE,
                             genre_id INT REFERENCES genres(id) ON DELETE CASCADE,
                             PRIMARY KEY (user_id, genre_id)
);

CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_user_genres_user_id ON user_genres(user_id);