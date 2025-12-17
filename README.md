# Mobile Automation Testing with Appium and TestNG

This project provides automated test scripts for mobile application testing using Appium and TestNG. The framework is designed to test the Sauce Labs demo application on Android emulators.

## Features

- **Page Object Model (POM) Design Pattern**
- **TestNG** for test execution and reporting
- **Extent Reports** for detailed test reporting
- **Data-Driven Testing** using CSV files
- **Screenshot** capture on test failure
- Support for **parallel test execution**

## Prerequisites

- Java JDK 11 or higher
- Android Studio with Android SDK
- Appium Server
- Node.js and npm
- Appium Java Client
- TestNG

## Setup Instructions

1. **Clone the repository**
   ```bash
   git clone [your-repository-url]
   cd mobile-demo-emulator
   ```

2. **Install Dependencies**
   ```bash
   ./gradlew build
   ```

3. **Configure Test Environment**
   Update the following in `src/test/resources/config.properties`:
   - `appPath`: Path to your APK file
   - `platformVersion`: Your Android emulator version
   - `deviceName`: Your device/emulator name
   - `appiumServer`: Appium server URL

4. **Start Appium Server**
   ```bash
   appium
   ```

5. **Start Android Emulator**
   - Open Android Studio
   - Launch AVD Manager
   - Start your preferred Android emulator

## Running Tests

### Run All Tests
```bash
./gradlew test
```

### Run Specific Test Class
```bash
./gradlew test --tests tests.LoginTest
```

## Test Cases

### Login Tests
- Valid login with correct credentials
- Invalid login with wrong credentials

### Shopping Cart Tests
- Add item to cart
- Remove item from cart
- Checkout flow
- Product sorting

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   ├── core/           # Base classes and utilities
│   │   └── pages/          # Page Object Model classes
│   └── resources/          # Resource files
└── test/
    ├── java/
    │   ├── core/           # Test base classes
    │   ├── tests/          # Test classes
    │   └── utils/          # Test utilities
    └── resources/          # Test data and configurations
```

## Reporting

Test execution reports are generated in the `reports/` directory. The framework uses Extent Reports for detailed test reporting with screenshots.

## Configuration

Edit `src/test/resources/config.properties` to configure:
- Appium server settings
- Device capabilities
- Test application details
- Test data paths

## Troubleshooting

1. **Appium server not starting**
   - Ensure Appium is installed globally: `npm install -g appium`
   - Check if required ports are available

2. **Emulator/Device not detected**
   - Verify Android SDK path is set correctly
   - Check if the device is connected and authorized
   - Run `adb devices` to list connected devices

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
