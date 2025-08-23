[Home](../../README.md)

# 3. Commerce Classic Site Initializer

Documentation: https://learn.liferay.com/w/dxp/commerce/starting-a-store/using-the-commerce-classic-site-initializer

## Overview 

Commerce Classic Site Initializer is a modern way to set up a new Liferay Commerce site using brand-new Liferay UI features for orders, account management and checkout process.

_**Note**: this feature is behind a beta feature flag (LPD-20379), and should be enabled in Feature Flags:_

![01-feature-flag.png](images/01-feature-flag.png)

## Pages Structure

A Liferay Commerce site created from Commerce Classic Site Initializer has the following pages structure:

- Catalog
  - Compare
  - Product Detail
- Orders
  - Pending Orders
    - Checkout
  - Placed Orders
- Returns
- Account Management
- Lists
- Search

## Master Page Overview

The Master Page Commerce Classic Overview has the following structure:

![02-master-page.png](images/02-master-page.png)

### Header
- #### Commerce Header User Fragment
    Displays the user profile menu, language and currency selectors.
    [Source Link](https://github.com/liferay/liferay-portal/tree/master/modules/apps/commerce/commerce-site-initializer/commerce-site-initializer/src/main/resources/site-initializer/fragments/group/commerce/fragments/header-user)
- #### Site Logo
- #### Search
- #### Commerce Components Group Fragment
    Displays account selector and mini-cart. 
    [Source Link](https://github.com/liferay/liferay-portal/tree/master/modules/apps/commerce/commerce-site-initializer/commerce-site-initializer/src/main/resources/site-initializer/fragments/group/commerce/fragments/commerce-components-group)
### DropZone
### Footer
Displays footer menu and social media links.

## Display Page Template Overview

The Order Display Page Template has the following structure:
![03-order-dpt.png](images/03-order-dpt.png)

### Order Header

##### UI

![04-order-header.png](images/04-order-header.png)

##### Description

Contains Order and Workflow status, Order name (customizable) and ERC, Checkout link and actions 

##### Components 

Fragments rendered with FragmentRenderer, available only with LPD-20379 feature flag:
- [Order Status Label](https://github.com/liferay/liferay-portal/blob/master/modules/apps/commerce/commerce-order-content-web/src/main/java/com/liferay/commerce/order/content/web/internal/fragment/renderer/StatusLabelFragmentRenderer.java)
- [Inline Editable Order Field](https://github.com/liferay/liferay-portal/blob/master/modules/apps/commerce/commerce-order-content-web/src/main/java/com/liferay/commerce/order/content/web/internal/fragment/renderer/InlineEditableOrderFieldFragmentRenderer.java)
- [Order Actions](https://github.com/liferay/liferay-portal/blob/master/modules/apps/commerce/commerce-order-content-web/src/main/java/com/liferay/commerce/order/content/web/internal/fragment/renderer/OrderActionsFragmentRenderer.java)

### Order Tabs

##### UI

![05-order-tabs.png](images/05-order-tabs.png)

##### Description

Tabs navigation between Order Details, Returns and Shipments

##### Components

Tabs fragment with DropZones.

### Order Steps

##### UI

![06-order-steps.png](images/06-order-steps.png)

##### Description

Displays progress on order steps.

##### Components

Fragment rendered with FragmentRenderer, available only with LPD-20379 feature flag:
- [Placed Order Shipments Data Set](https://github.com/liferay/liferay-portal/blob/master/modules/apps/commerce/commerce-order-content-web/src/main/java/com/liferay/commerce/order/content/web/internal/fragment/renderer/PlacedOrderShipmentsDataSetFragmentRenderer.java)

### Order Details

##### UI

![07-order-details.png](images/07-order-details.png)

##### Description

Displays order details: account and order information, shipping and billing addresses, payment method, etc.

##### Components

A Grid with [Info Box](https://github.com/liferay/liferay-portal/blob/master/modules/apps/commerce/commerce-order-content-web/src/main/java/com/liferay/commerce/order/content/web/internal/fragment/renderer/InfoBoxFragmentRenderer.java) fragments.

### Order Items

##### UI

![08-order-items.png](images/08-order-items.png)

##### Description

Displays information about order items.

##### Components

[Order Items Data Set](https://github.com/liferay/liferay-portal/blob/master/modules/apps/commerce/commerce-order-content-web/src/main/java/com/liferay/commerce/order/content/web/internal/fragment/renderer/OrderItemsDataSetFragmentRenderer.java)

### Order Items

##### UI

![09-order-summary.png](images/09-order-summary.png)

##### Description

Displays order summary information.

##### Components

A Grid with [Order Summary](https://github.com/liferay/liferay-portal/blob/master/modules/apps/commerce/commerce-order-content-web/src/main/java/com/liferay/commerce/order/content/web/internal/fragment/renderer/OrderSummaryFragmentRenderer.java) fragments.