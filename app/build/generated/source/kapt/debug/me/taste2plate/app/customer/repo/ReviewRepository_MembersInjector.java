// Generated by Dagger (https://dagger.dev).
package me.taste2plate.app.customer.repo;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
import me.taste2plate.app.Woocommerce;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ReviewRepository_MembersInjector implements MembersInjector<ReviewRepository> {
  private final Provider<Woocommerce> woocommerceProvider;

  public ReviewRepository_MembersInjector(Provider<Woocommerce> woocommerceProvider) {
    this.woocommerceProvider = woocommerceProvider;
  }

  public static MembersInjector<ReviewRepository> create(
      Provider<Woocommerce> woocommerceProvider) {
    return new ReviewRepository_MembersInjector(woocommerceProvider);
  }

  @Override
  public void injectMembers(ReviewRepository instance) {
    injectWoocommerce(instance, woocommerceProvider.get());
  }

  @InjectedFieldSignature("me.taste2plate.app.customer.repo.ReviewRepository.woocommerce")
  public static void injectWoocommerce(ReviewRepository instance, Woocommerce woocommerce) {
    instance.woocommerce = woocommerce;
  }
}
