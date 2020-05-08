<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div id="registration">
    <h3 class="text-center text-white pt-5">Registration form</h3>
    <div class="container">
        <div id="registration-row" class="row justify-content-center align-items-center">
            <div id="registration-column" class="col-md-6">
                <div id="registration-box" class="col-md-12">
                    <form id="registration-form" class="form" action="" method="post">
                        <h3 class="text-center text-info">Registration</h3>

                        <div class="form-group">
                            <label for="username" class="text-info">Username:</label><br>
                            <input type="text" name="username" id="username"
                                   value="<#if username??>${username}</#if>"
                                   class="form-control <#if username_errors?has_content> is-invalid<#else> is-valid</#if>"
                                   placeholder="email@email.com">
                            <#if username_errors??>
                                <div class="invalid-feedback">
                                    <#list username_errors as error>${error}</#list>
                                </div>
                            </#if>
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info">Password:</label><br>
                            <input type="password" name="password" id="password"
                                   class="form-control <#if password_errors?has_content>is-invalid<#else>is-valid</#if>"
                                   placeholder="Password:Greeting2u$er">
                            <#if password_errors??>
                                <div class="invalid-feedback">
                                    <#list password_errors as error>${error}</#list>
                                </div>
                            </#if>
                            <meter max="4" id="password-strength-meter"></meter>
                            <b id="password-strength-text"></b>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                        </div>
                        <div id="register-link" class="text-right">
                            <a href="/login" class="text-info">Login here</a>
                        </div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script>
    var strength = {
        0: "Worst",
        1: "Bad",
        2: "Weak",
        3: "Good",
        4: "Strong"
    }
    var password = document.getElementById('password');
    var meter = document.getElementById('password-strength-meter');
    var text = document.getElementById('password-strength-text');

    password.addEventListener('input', function () {
        var val = password.value;
        var result = zxcvbn(val);

        // Update the password strength meter
        meter.value = result.score;

        // Update the text indicator
        if (val !== "") {
            text.innerHTML = "Strength: " + strength[result.score];
        } else {
            text.innerHTML = "";
        }
    });
</script>
</body>
</html>