return redis.call("zrevrange", "games:joust", 0, -1, "WITHSCORES")
