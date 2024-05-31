import Data.Char

scoreOfString :: String -> Int
scoreOfString = sum . map (abs . uncurry (-)) . zipPairs . map ord

zipPairs :: [a] -> [(a, a)]
zipPairs = zip <*> tail 

