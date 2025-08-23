[Home](../../README.md)

# 1. Liferay Commerce: Overview

## Store Management

### Store Types

Liferay Commerce supports three types of stores:
- **B2B** (business to business): requires business accounts;
- **B2C** (business to consumer): requires personal accounts;
- **B2X** (combined): recognizes personal and business accounts.

![01-store-types.png](images/01-store-types.png)

### Channels

**[Channels](https://learn.liferay.com/w/dxp/commerce/store-management/channels)** represent a place where you sell products: a Liferay customer portal, a B2B marketplace, or even back office phone sales.

Channel configuration options:
1. General: Details, Prices, Orders, Payment Methods, Shipping Methods, Tax Calculations.
2. Type: association with Liferay Site
3. Notification Queue (deprecated)
4. Notification Templates (deprecated)
5. Category Display Pages
6. Product Display Pages
7. Payment Restrictions
8. Shipping Restrictions
9. Countries
10. Eligibility: all accounts or specific account(s).

## Product Management

### Catalogs

A [catalog](https://learn.liferay.com/w/dxp/commerce/product-management/catalogs) contains all the information about the products you’re selling. Before starting a store, you must create at least one catalog and add products to it. Catalogs are scoped to an instance.