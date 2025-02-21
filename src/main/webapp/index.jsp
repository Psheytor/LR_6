<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Word in File</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .result {
            margin-top: 20px;
            font-size: 18px;
        }
    </style>
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-body">
                    <h1 class="card-title text-center mb-4">Search Word in File</h1>
                    <form action="/search" method="get" accept-charset="UTF-8">
                        <div class="mb-3">
                            <label for="keyword" class="form-label">Enter a word to search:</label>
                            <input type="text" class="form-control" id="keyword" name="keyword" placeholder="Type a word" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Search</button>
                        </div>
                    </form>
                    <div class="result mt-4" id="result">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>