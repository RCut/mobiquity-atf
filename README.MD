<h1>Mobiquity task. Automated Testing Framework</h1>
<h2>Overview</h2>
<p>This framework is build to demonstrate the design of a test harness applicable to 
solve testing tasks such as <b>Integration/Component/System Integration/E2E</b> level 
testing.</p>
<p>It provides a modular architecture and basic capabilities which can be extended and 
enhanced.</p>
<h3>Tech stack</h3>
<ul>
    <li>Spring Boot</li>
    <li>Cucumber + Junit 4</li>
    <li>Allure</li>
    <li>RestAssured</li>
</ul>
<h2>Test execution</h2>
<b>Backend tests</b> (API) can be executed using:
<li><code>com.mobiquity.test.backend.RunBackendCukeTest</code> test runner</li>
<li><code>mvn clean test</code> command</li>
<p><b>Allure</b> reports can be displayed using the <code>mvn allure:serve</code> command</p>